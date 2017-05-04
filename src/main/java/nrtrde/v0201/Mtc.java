/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package nrtrde.v0201;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class Mtc implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 4);

	public byte[] code = null;
	private Imsi imsi = null;
	private Imei imei = null;
	private CallEventStartTimeStamp callEventStartTimeStamp = null;
	private UtcTimeOffset utcTimeOffset = null;
	private CallEventDuration callEventDuration = null;
	private CauseForTermination causeForTermination = null;
	private ServiceCode serviceCode = null;
	private CallingNumber callingNumber = null;
	private RecEntityId recEntityId = null;
	private CallReference callReference = null;
	private ChargeAmount chargeAmount = null;
	private ServingNetwork servingNetwork = null;
	private Msisdn msisdn = null;
	private LocationArea locationArea = null;
	private CellId cellId = null;
	
	public Mtc() {
	}

	public Mtc(byte[] code) {
		this.code = code;
	}

	public void setImsi(Imsi imsi) {
		this.imsi = imsi;
	}

	public Imsi getImsi() {
		return imsi;
	}

	public void setImei(Imei imei) {
		this.imei = imei;
	}

	public Imei getImei() {
		return imei;
	}

	public void setCallEventStartTimeStamp(CallEventStartTimeStamp callEventStartTimeStamp) {
		this.callEventStartTimeStamp = callEventStartTimeStamp;
	}

	public CallEventStartTimeStamp getCallEventStartTimeStamp() {
		return callEventStartTimeStamp;
	}

	public void setUtcTimeOffset(UtcTimeOffset utcTimeOffset) {
		this.utcTimeOffset = utcTimeOffset;
	}

	public UtcTimeOffset getUtcTimeOffset() {
		return utcTimeOffset;
	}

	public void setCallEventDuration(CallEventDuration callEventDuration) {
		this.callEventDuration = callEventDuration;
	}

	public CallEventDuration getCallEventDuration() {
		return callEventDuration;
	}

	public void setCauseForTermination(CauseForTermination causeForTermination) {
		this.causeForTermination = causeForTermination;
	}

	public CauseForTermination getCauseForTermination() {
		return causeForTermination;
	}

	public void setServiceCode(ServiceCode serviceCode) {
		this.serviceCode = serviceCode;
	}

	public ServiceCode getServiceCode() {
		return serviceCode;
	}

	public void setCallingNumber(CallingNumber callingNumber) {
		this.callingNumber = callingNumber;
	}

	public CallingNumber getCallingNumber() {
		return callingNumber;
	}

	public void setRecEntityId(RecEntityId recEntityId) {
		this.recEntityId = recEntityId;
	}

	public RecEntityId getRecEntityId() {
		return recEntityId;
	}

	public void setCallReference(CallReference callReference) {
		this.callReference = callReference;
	}

	public CallReference getCallReference() {
		return callReference;
	}

	public void setChargeAmount(ChargeAmount chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public ChargeAmount getChargeAmount() {
		return chargeAmount;
	}

	public void setServingNetwork(ServingNetwork servingNetwork) {
		this.servingNetwork = servingNetwork;
	}

	public ServingNetwork getServingNetwork() {
		return servingNetwork;
	}

	public void setMsisdn(Msisdn msisdn) {
		this.msisdn = msisdn;
	}

	public Msisdn getMsisdn() {
		return msisdn;
	}

	public void setLocationArea(LocationArea locationArea) {
		this.locationArea = locationArea;
	}

	public LocationArea getLocationArea() {
		return locationArea;
	}

	public void setCellId(CellId cellId) {
		this.cellId = cellId;
	}

	public CellId getCellId() {
		return cellId;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {
		return encode(os, true);
	}

	public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (cellId != null) {
			codeLength += cellId.encode(os, true);
		}
		
		if (locationArea != null) {
			codeLength += locationArea.encode(os, true);
		}
		
		if (msisdn != null) {
			codeLength += msisdn.encode(os, true);
		}
		
		if (servingNetwork != null) {
			codeLength += servingNetwork.encode(os, true);
		}
		
		if (chargeAmount != null) {
			codeLength += chargeAmount.encode(os, true);
		}
		
		if (callReference != null) {
			codeLength += callReference.encode(os, true);
		}
		
		if (recEntityId != null) {
			codeLength += recEntityId.encode(os, true);
		}
		
		if (callingNumber != null) {
			codeLength += callingNumber.encode(os, true);
		}
		
		if (serviceCode != null) {
			codeLength += serviceCode.encode(os, true);
		}
		
		if (causeForTermination != null) {
			codeLength += causeForTermination.encode(os, true);
		}
		
		if (callEventDuration != null) {
			codeLength += callEventDuration.encode(os, true);
		}
		
		if (utcTimeOffset != null) {
			codeLength += utcTimeOffset.encode(os, true);
		}
		
		if (callEventStartTimeStamp != null) {
			codeLength += callEventStartTimeStamp.encode(os, true);
		}
		
		if (imei != null) {
			codeLength += imei.encode(os, true);
		}
		
		if (imsi != null) {
			codeLength += imsi.encode(os, true);
		}
		
		codeLength += BerLength.encodeLength(os, codeLength);

		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		if (totalLength == 0) {
			return codeLength;
		}
		subCodeLength += berTag.decode(is);
		if (berTag.equals(Imsi.tag)) {
			imsi = new Imsi();
			subCodeLength += imsi.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(Imei.tag)) {
			imei = new Imei();
			subCodeLength += imei.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CallEventStartTimeStamp.tag)) {
			callEventStartTimeStamp = new CallEventStartTimeStamp();
			subCodeLength += callEventStartTimeStamp.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(UtcTimeOffset.tag)) {
			utcTimeOffset = new UtcTimeOffset();
			subCodeLength += utcTimeOffset.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CallEventDuration.tag)) {
			callEventDuration = new CallEventDuration();
			subCodeLength += callEventDuration.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CauseForTermination.tag)) {
			causeForTermination = new CauseForTermination();
			subCodeLength += causeForTermination.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ServiceCode.tag)) {
			serviceCode = new ServiceCode();
			subCodeLength += serviceCode.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CallingNumber.tag)) {
			callingNumber = new CallingNumber();
			subCodeLength += callingNumber.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(RecEntityId.tag)) {
			recEntityId = new RecEntityId();
			subCodeLength += recEntityId.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CallReference.tag)) {
			callReference = new CallReference();
			subCodeLength += callReference.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ChargeAmount.tag)) {
			chargeAmount = new ChargeAmount();
			subCodeLength += chargeAmount.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ServingNetwork.tag)) {
			servingNetwork = new ServingNetwork();
			subCodeLength += servingNetwork.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(Msisdn.tag)) {
			msisdn = new Msisdn();
			subCodeLength += msisdn.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(LocationArea.tag)) {
			locationArea = new LocationArea();
			subCodeLength += locationArea.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CellId.tag)) {
			cellId = new CellId();
			subCodeLength += cellId.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		boolean firstSelectedElement = true;
		if (imsi != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("imsi: ").append(imsi);
			firstSelectedElement = false;
		}
		
		if (imei != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("imei: ").append(imei);
			firstSelectedElement = false;
		}
		
		if (callEventStartTimeStamp != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("callEventStartTimeStamp: ").append(callEventStartTimeStamp);
			firstSelectedElement = false;
		}
		
		if (utcTimeOffset != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("utcTimeOffset: ").append(utcTimeOffset);
			firstSelectedElement = false;
		}
		
		if (callEventDuration != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("callEventDuration: ").append(callEventDuration);
			firstSelectedElement = false;
		}
		
		if (causeForTermination != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("causeForTermination: ").append(causeForTermination);
			firstSelectedElement = false;
		}
		
		if (serviceCode != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("serviceCode: ");
			serviceCode.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (callingNumber != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("callingNumber: ").append(callingNumber);
			firstSelectedElement = false;
		}
		
		if (recEntityId != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("recEntityId: ").append(recEntityId);
			firstSelectedElement = false;
		}
		
		if (callReference != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("callReference: ").append(callReference);
			firstSelectedElement = false;
		}
		
		if (chargeAmount != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargeAmount: ").append(chargeAmount);
			firstSelectedElement = false;
		}
		
		if (servingNetwork != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("servingNetwork: ").append(servingNetwork);
			firstSelectedElement = false;
		}
		
		if (msisdn != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("msisdn: ").append(msisdn);
			firstSelectedElement = false;
		}
		
		if (locationArea != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("locationArea: ").append(locationArea);
			firstSelectedElement = false;
		}
		
		if (cellId != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("cellId: ").append(cellId);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}
