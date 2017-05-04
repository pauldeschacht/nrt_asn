# Project: nrt_asn

Parse NRTRDE files and output the BER/DER as nested csv, denormalized csv or as structured JSON like on the console

## Usage 

The repo (nrt_asn/lib) contains the assembly jar nrt_asn.jar (includes all the dependencies).

<code>
java -jar nrt_asn -i <input>

java -jar nrt_asn -i <input> -f
</code>

### Arguments:

-h help 

-i input file or input folder. In case of a folder, all files will be parsed as NRTRDE

-d print the denormalized csv output. This is the default option

-j print JSON like format

-n print the nested csv output. This option can be combined with the

-f print the header for the csv output.




## Denormalized CSV output 

TODO

## Nested CSV output

### Main level (level 1)
The main fields are separated by ^
<code>
specificationVersionNumber^releaseVersionNumber^sender^..^utcTimeOffset^moclist^mctlist^gprslist
</code>

### List (level 2)
Each callevent lists (moclist, mctlist and gprslist) has a sequence of callevent. Each callevent is separate by a '*'

<code>
^utcTimeOffset^moc*moc^mct*mct^grps^gprs
</code>

### Event (level 3)

The fields in each callevent are separated by a ','

<code>
Imsi,Imei,CallEventStartTimeStamp,..
</code>

## Structured output

The structured output is part of the openmuc external libraries (see below).

java -jar nrt_asn -i <input> -j

{

	specificationVersionNumber: ,
  
	releaseVersionNumber: ,
  
	sender: ,
  
	recipient: ,
  
	sequenceNumber: ,
  
	fileAvailableTimeStamp: ,
  
	utcTimeOffset: ,
  
	callEvents: {
  
		mtc: {
    
				imsi: ,
        
				imei: ,
        
				callEventStartTimeStamp: ,
        
				utcTimeOffset: ,
        
				callEventDuration: ,
        
				causeForTermination: ,
        
				serviceCode: teleServiceCode: ,
        
				callingNumber: ,
        
				recEntityId: ,
        
				callReference: 
        
			},
      
		mtc: {
    
				imsi: ,
        
				imei: ,
        
				callEventStartTimeStamp: ,
        
				utcTimeOffset: ,
        
				callEventDuration: ,
        
				causeForTermination: ,
        
				serviceCode: teleServiceCode: ,
        
				callingNumber: ,
        
				recEntityId: ,
        
				callReference: 
        
			}
      
	},
  
	callEventsCount: 
  
}


## External dependencies

The ASN parser files are generated using the tool https://www.openmuc.org/asn1/. The generated Java source files can be found in src\main\java\nrtrde\v0201.
 
 ### Remark
 
 Slight modification of the ASN file: I've changed the module name in order to avoid illegal Java package name (0201)
 <code>
 NRTRDE-0201  DEFINITIONS IMPLICIT TAGS  ::= 
 </code>
  into 
 <code>
 NRTRDE-v0201  DEFINITIONS IMPLICIT TAGS  ::= 
 </code>
 
