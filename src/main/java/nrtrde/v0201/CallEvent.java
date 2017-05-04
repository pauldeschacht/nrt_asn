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


public class CallEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	private Moc moc = null;
	private Mtc mtc = null;
	private Gprs gprs = null;
	
	public CallEvent() {
	}

	public CallEvent(byte[] code) {
		this.code = code;
	}

	public void setMoc(Moc moc) {
		this.moc = moc;
	}

	public Moc getMoc() {
		return moc;
	}

	public void setMtc(Mtc mtc) {
		this.mtc = mtc;
	}

	public Mtc getMtc() {
		return mtc;
	}

	public void setGprs(Gprs gprs) {
		this.gprs = gprs;
	}

	public Gprs getGprs() {
		return gprs;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (gprs != null) {
			codeLength += gprs.encode(os, true);
			return codeLength;
		}
		
		if (mtc != null) {
			codeLength += mtc.encode(os, true);
			return codeLength;
		}
		
		if (moc != null) {
			codeLength += moc.encode(os, true);
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(Moc.tag)) {
			moc = new Moc();
			codeLength += moc.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(Mtc.tag)) {
			mtc = new Mtc();
			codeLength += mtc.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(Gprs.tag)) {
			gprs = new Gprs();
			codeLength += gprs.decode(is, false);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (moc != null) {
			sb.append("moc: ");
			moc.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (mtc != null) {
			sb.append("mtc: ");
			mtc.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (gprs != null) {
			sb.append("gprs: ");
			gprs.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

