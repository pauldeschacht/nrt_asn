import nrtrde.v0201.*;
import org.openmuc.jasn1.ber.types.BerInteger;
import org.openmuc.jasn1.ber.types.BerOctetString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdeschacht on 01/05/2017.
 */
public class NrtrdeToCsv {
    static public String SEP_LEVEL1 = "^";
    static public String SEP_LEVEL2 = "*";
    static public String SEP_LEVEL3 = ",";

    public class struct {
        public List<String> header;
        public List<List<String>> mocList;
        public List<List<String>> mctList;
        public List<List<String>> gprsList;
    }

    public static String toCsv(Nrtrde nrtrde) {
        List<String> tokens = new ArrayList<String>();
        tokens.add(toString(nrtrde.getSpecificationVersionNumber()));
        tokens.add(toString(nrtrde.getReleaseVersionNumber()));
        tokens.add(toString(nrtrde.getSender()));
        tokens.add(toString(nrtrde.getRecipient()));
        tokens.add(toString(nrtrde.getSequenceNumber()));
        tokens.add(toString(nrtrde.getFileAvailableTimeStamp()));
        tokens.add(toString(nrtrde.getUtcTimeOffset()));
        tokens.add(toString(nrtrde.getCallEventsCount()));
        List<List<String>> mocs = MocList(nrtrde.getCallEvents().getCallEvent());
        tokens.add(interpose(mocs,SEP_LEVEL2,SEP_LEVEL3));
        List<List<String>> mcts = MctList(nrtrde.getCallEvents().getCallEvent());
        tokens.add(interpose(mcts,SEP_LEVEL2,SEP_LEVEL3));
        List<List<String>> gprs = GprsList(nrtrde.getCallEvents().getCallEvent());
        tokens.add(interpose(gprs,SEP_LEVEL2,SEP_LEVEL3));
        return interpose(tokens,SEP_LEVEL1);
    }

    public static List<String> denormalizedCsv(Nrtrde nrtrde) {
        List<String> header = new ArrayList<String>();
        header.add(toString(nrtrde.getSpecificationVersionNumber()));
        header.add(toString(nrtrde.getReleaseVersionNumber()));
        header.add(toString(nrtrde.getSender()));
        header.add(toString(nrtrde.getRecipient()));
        header.add(toString(nrtrde.getSequenceNumber()));
        header.add(toString(nrtrde.getFileAvailableTimeStamp()));
        header.add(toString(nrtrde.getUtcTimeOffset()));
        header.add(toString(nrtrde.getCallEventsCount()));

        List<List<String>> mocs = MocList(nrtrde.getCallEvents().getCallEvent());
        List<List<String>> mcts = MctList(nrtrde.getCallEvents().getCallEvent());
        List<List<String>> gprs = GprsList(nrtrde.getCallEvents().getCallEvent());

        List<String> mocLines =  denormalize(header, mocs, "moc");
        List<String> mctLines =  denormalize(header, mcts, "mct");
        List<String> gprsLines = denormalize(header, gprs, "gprs");

        for(String s:mctLines) {
            mocLines.add(s);
        }
        for(String s:gprsLines) {
            mocLines.add(s);
        }
        return mocLines;
    }

    private static List<String> denormalize(List<String> header, List<List<String>> values, String type) {
        List<String> lines = new ArrayList<String>();
        for(List<String> eventDetails: values) {
            List<String> tempLine = new ArrayList<String>(header);
            tempLine.add(type);
            for(String s : eventDetails) {
                tempLine.add(s);
            }
            String eventLine = interpose(tempLine,SEP_LEVEL1);
            lines.add(eventLine);
        }
        return lines;
    }

    public static List<List<String>> MocList(List<CallEvent> list) {
        List<List<String>> tokens = new ArrayList<List<String>>();
        for(CallEvent event: list) {
            if (event.getMoc() != null) {
                List<String> ss= MocEvent(event);
                tokens.add(ss);
            }
        }
        return tokens;
    }
    public static List<List<String>> MctList(List<CallEvent> list) {
        List<List<String>> tokens = new ArrayList<List<String>>();
        for(CallEvent event: list) {
            if (event.getMtc() != null) {
                List<String> ss = MctEvent(event);
                tokens.add(ss);
            }
        }
        return tokens;
    }
    public static List<List<String>> GprsList(List<CallEvent> list ) {
        List<List<String>> tokens = new ArrayList<List<String>>();
        for(CallEvent event: list) {
            if (event.getGprs() != null) {
                List<String> ss = GprsEvent(event);
                tokens.add(ss);
            }
        }
        return tokens;
    }
    /**
     * moc event to list of strings
     */
    public static List<String> MocEvent(CallEvent event) {
        List<String> eventToken = new ArrayList<String>();
        Moc m = event.getMoc();
        eventToken.add(toString(m.getImsi()));
        eventToken.add(toString(m.getImei()));
        eventToken.add(toString(m.getCallEventStartTimeStamp()));
        eventToken.add(toString(m.getUtcTimeOffset()));
        eventToken.add(toString(m.getCallEventDuration()));
        eventToken.add(toString(m.getCauseForTermination()));
        eventToken.add(toString(m.getServiceCode()));
        eventToken.add(toString(m.getSupplementaryServiceCode()));
        eventToken.add(toString(m.getDialledDigits()));
        eventToken.add(toString(m.getConnectedNumber()));
        eventToken.add(toString(m.getThirdPartyNumber()));
        eventToken.add(toString(m.getRecEntityId()));
        eventToken.add(toString(m.getCallReference()));
        eventToken.add(toString(m.getChargeAmount()));
        eventToken.add(toString(m.getServingNetwork()));
        eventToken.add(toString(m.getMsisdn()));
        eventToken.add(toString(m.getLocationArea()));
        eventToken.add(toString(m.getCellId()));
        return eventToken;
    }
    /**
     * mct event to list of strings
     */    public static List<String> MctEvent(CallEvent event) {
        List<String> eventToken = new ArrayList<String>();
        Mtc m = event.getMtc();
        eventToken.add(toString(m.getImsi()));
        eventToken.add(toString(m.getImei()));
        eventToken.add(toString(m.getCallEventStartTimeStamp()));
        eventToken.add(toString(m.getUtcTimeOffset()));
        eventToken.add(toString(m.getCallEventDuration()));
        eventToken.add(toString(m.getCauseForTermination()));
        eventToken.add(toString(m.getServiceCode()));
        eventToken.add(toString(m.getCallingNumber()));
        eventToken.add(toString(m.getRecEntityId()));
        eventToken.add(toString(m.getCallReference()));
        eventToken.add(toString(m.getChargeAmount()));
        eventToken.add(toString(m.getServingNetwork()));
        eventToken.add(toString(m.getMsisdn()));
        eventToken.add(toString(m.getLocationArea()));
        eventToken.add(toString(m.getCellId()));
        return eventToken;
    }
    /**
     * gprs event to list of strings
     */
    public static List<String> GprsEvent(CallEvent event) {
        List<String> eventToken = new ArrayList<String>();
        Gprs m = event.getGprs();
        eventToken.add(toString(m.getImsi()));
        eventToken.add(toString(m.getImei()));
        eventToken.add(toString(m.getCallEventStartTimeStamp()));
        eventToken.add(toString(m.getUtcTimeOffset()));
        eventToken.add(toString(m.getCallEventDuration()));
        eventToken.add(toString(m.getCauseForTermination()));
        eventToken.add(toString(m.getAccessPointNameNI()));
        eventToken.add(toString(m.getAccessPointNameOI()));
        eventToken.add(toString(m.getDataVolumeIncoming()));
        eventToken.add(toString(m.getDataVolumeOutgoing()));
        eventToken.add(toString(m.getSgsnAddress()));
        eventToken.add(toString(m.getGgsnAddress()));
        eventToken.add(toString(m.getChargingId()));
        eventToken.add(toString(m.getChargeAmount()));
        eventToken.add(toString(m.getServingNetwork()));
        eventToken.add(toString(m.getMsisdn()));
        eventToken.add(toString(m.getLocationArea()));
        eventToken.add(toString(m.getCellId()));
        return eventToken;
    }
    /**
     * HEADER functions
     */
    public static String header() {
        List<String> tokens = new ArrayList<String>();
        tokens.add("specificationVersionNumber");
        tokens.add("releaseVersionNumber");
        tokens.add("sender");
        tokens.add("recipient");
        tokens.add("sequenceNumber");
        tokens.add("fileAvailableTimeStamp");
        tokens.add("utcTimeOffset");
        tokens.add(mocListHeader());
        tokens.add(mctListHeader());
        tokens.add(gprsListHeader());

        return interpose(tokens,SEP_LEVEL1);
    }
    public static String mocListHeader() {
        List<String> tokens = new ArrayList<String>();
        tokens.add("Imsi");
        tokens.add("Imei");
        tokens.add("CallEventStartTimeStamp");
        tokens.add("UtcTimeOffset");
        tokens.add("CallEventDuration");
        tokens.add("CauseForTermination");
        tokens.add("ServiceCode");
        tokens.add("SupplementaryServiceCode");
        tokens.add("DialledDigits");
        tokens.add("ConnectedNumber");
        tokens.add("ThirdPartyNumber");
        tokens.add("RecEntityId");
        tokens.add("CallReference");
        tokens.add("ChargeAmount");
        tokens.add("ServingNetwork");
        tokens.add("Msisdn");
        tokens.add("LocationArea");
        tokens.add("CellId");
        return interpose(tokens,SEP_LEVEL3) + SEP_LEVEL2;
    }
    public static String mctListHeader() {
        List<String> tokens = new ArrayList<String>();
        tokens.add("Imsi");
        tokens.add("Imei");
        tokens.add("CallEventStartTimeStamp");
        tokens.add("UtcTimeOffset");
        tokens.add("CallEventDuration");
        tokens.add("CauseForTermination");
        tokens.add("ServiceCode");
        tokens.add("SupplementaryServiceCode");
        tokens.add("DialledDigits");
        tokens.add("ConnectedNumber");
        tokens.add("ThirdPartyNumber");
        tokens.add("RecEntityId");
        tokens.add("CallReference");
        tokens.add("ChargeAmount");
        tokens.add("ServingNetwork");
        tokens.add("Msisdn");
        tokens.add("LocationArea");
        tokens.add("CellId");
        return interpose(tokens,SEP_LEVEL3) + SEP_LEVEL2;
    }
    public static String gprsListHeader() {
        List<String> tokens = new ArrayList<String>();
        tokens.add("Imsi");
        tokens.add("Imei");
        tokens.add("CallEventStartTimeStamp");
        tokens.add("UtcTimeOffset");
        tokens.add("CallEventDuration");
        tokens.add("CauseForTermination");
        tokens.add("AccessPointNameNI");
        tokens.add("AccessPointNameOI");
        tokens.add("DataVolumeIncoming");
        tokens.add("DataVolumeOutgoing");
        tokens.add("SgsnAddress");
        tokens.add("GgsnAddress");
        tokens.add("ChargingId");
        tokens.add("ChargeAmount");
        tokens.add("ServingNetwork");
        tokens.add("Msisdn");
        tokens.add("LocationArea");
        tokens.add("CellId");
        return interpose(tokens,SEP_LEVEL3) + SEP_LEVEL2;
    }
    /**
     * helper functions
     */
    private static String toString(ServiceCode code) {
        String s = "";
        if (code!=null) {
            s += toString(code.getTeleServiceCode());
            s += toString(code.getBearerServiceCode());
            return s;
        }
        return "";
    }
    private static String toString(BerInteger i) {
        if (i!=null) {
            return i.toString();
        }
        return "";
    }
    private static String toString(BerOctetString s) {
        if (s!=null) {
            return s.toString();
        }
        return "";
    }
    private static String interpose(List<String> list, String separator) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size()-1;i++) {
            sb.append(list.get(i));
            sb.append(separator);
        }
        if (list.size() > 1) {
            sb.append(list.get(list.size() - 1));
        }
        return sb.toString();
    }
    private static String interpose(List<List<String>> list, String sep1, String sep2) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size()-1; i++) {
            sb.append(interpose(list.get(i),sep2));
            sb.append(sep1);
        }
        if (list.size()>1) {
            sb.append(interpose(list.get(list.size() - 1), sep2));
        }
        return sb.toString();
    }
}
