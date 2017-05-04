/**
 * Created by pdeschacht on 30/04/2017.
 */
import nrtrde.v0201.Nrtrde;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.lang.System.exit;

public class NrtrdeToCsvApplication {

    private enum OUTPUT_FORMAT {
        JSON,
        CSV_NESTED,
        CSV_DENORMALIZED

    }
     public static void main(String[] args) throws IOException {
        // create Options object
        Options options = new Options();
        //
        options.addOption("h", "help",  false, "print this message");
        options.addOption("i", "input", true, "input file or input folder");
        options.addOption("d", "denormalized", false, "output denormalized csv, not with --json argument");
        options.addOption("n", "nested csv", false, "output is nested csv");
        options.addOption("f", "fields",false, "add header to csv, not with --json argument");
        options.addOption("j", "json",  false, "output in structured format");

        options.getOption("i").setRequired(true);

        CommandLineParser parser = new DefaultParser();
        CommandLine line= null;
        try {
            line = parser.parse(options, args);
        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "java -jar nrt_asn.jar", options );
            e.printStackTrace();
            exit(0);
        }

        // help
        if (line.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "java -jar nrt_asn.jar", options );
            exit(0);
        }

        OUTPUT_FORMAT outputFormat = OUTPUT_FORMAT.CSV_DENORMALIZED;
        if (line.hasOption("j")) {
            outputFormat = OUTPUT_FORMAT.JSON;
        } else if (line.hasOption("d")) {
            outputFormat = OUTPUT_FORMAT.CSV_DENORMALIZED;
        }  else if (line.hasOption("n")) {
            outputFormat = OUTPUT_FORMAT.CSV_NESTED;
        }

        // print header if required
        if (outputFormat == OUTPUT_FORMAT.CSV_NESTED && line.hasOption("f")) {
            System.out.println(NrtrdeToCsv.header());
        }

        //input path (file or folder)
        String path = line.getOptionValue("i");
        File file = new File(path);
        if (file.isFile()) {
            Nrtrde nrtrde = processFile(file);
            output(nrtrde,outputFormat,file.getName());
        }
        else if (file.isDirectory()) {
            for(File f: file.listFiles()) {
                Nrtrde nrtrde = processFile(f);
                output(nrtrde,outputFormat,f.getName());
            }
        }
    }
    public static Nrtrde processFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        Nrtrde nrtrde = new Nrtrde();
        nrtrde.decode(is);
        return nrtrde;
    }
    public static void output(Nrtrde nrtrde, OUTPUT_FORMAT outputFormat, String filename) {
        switch (outputFormat) {
            case JSON: outputJson(nrtrde); break;
            case CSV_NESTED: outputNested(nrtrde);break;
            case CSV_DENORMALIZED: outputDenormalized(nrtrde,filename); break;
        }
    }
    public static void outputJson(Nrtrde nrtrde) {
        System.out.println(nrtrde.toString());
    }
    public static void outputNested(Nrtrde nrtrde) {
        System.out.println(NrtrdeToCsv.toCsv(nrtrde));
    }
    public static void outputDenormalized(Nrtrde nrtrde,String filename) {
         List<String> lines = NrtrdeToCsv.denormalizedCsv(nrtrde);
         for(String line: lines) {
             System.out.println(filename + NrtrdeToCsv.SEP_LEVEL1 + line);
         }
    }
}
