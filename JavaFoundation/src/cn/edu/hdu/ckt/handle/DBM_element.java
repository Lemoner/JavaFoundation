package cn.edu.hdu.ckt.handle;

import java.io.Serializable;

public class DBM_element implements Serializable{
	private int value;
	private boolean strictness;
	private int DBM_i;
	private int DBM_j;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isStrictness() {
		return strictness;
	}
	public void setStrictness(boolean strictness) {
		this.strictness = strictness;
	}
	public int getDBM_i() {
		return DBM_i;
	}
	public void setDBM_i(int dBM_i) {
		DBM_i = dBM_i;
	}
	public int getDBM_j() {
		return DBM_j;
	}
	public void setDBM_j(int dBM_j) {
		DBM_j = dBM_j;
	}
	
}

