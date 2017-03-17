package cn.edu.hdu.ckt.handle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Transition  implements Serializable{
	private String name;//�������Ǩ������/////
	private int id;//�������//////
	private String in;//////
	private String out;//////
	private String condition;///////
	private ArrayList<String> EventSet;//�¼�����	
	private String target;//ת��������Ŀ��״̬����
	private String source;//ת�������Դ״̬����
	private ArrayList<String> ResetClockSet;//Ǩ���и�λ��ʱ���������(ʱ����Ϊ0)
	private DBM_element[][] constraintDBM;//Ǩ���ϵ�ʱ��Լ������
	private ArrayList<String> types;
	private ArrayList<String> typeIds;

	
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//private ArrayList<DBM_element[][]> com_constraint;//Ǩ����ʱ��Լ���Ĳ���
	//private ArrayList<String> SetClock;//Ǩ�������õ�ʱ�ӣ�y=2��
	
	public ArrayList<String> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	public ArrayList<String> getTypeIds() {
		return typeIds;
	}
	public void setTypeIds(ArrayList<String> typeIds) {
		this.typeIds = typeIds;
	}
	/*public ArrayList<DBM_element[][]> getCom_constraint() {
		return com_constraint;
	}
	public void setCom_constraint(ArrayList<DBM_element[][]> com_constraint) {
		this.com_constraint = com_constraint;
	}*/
	/*public ArrayList<String> getSetClock() {
		return SetClock;
	}
	public void setSetClock(ArrayList<String> setClock) {
		SetClock = setClock;
	}*/
	public ArrayList<String> getEventSet() {
		return EventSet;
	}
	public void setEventSet(ArrayList<String> eventSet) {
		EventSet = eventSet;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public ArrayList<String> getResetClockSet() {
		return ResetClockSet;
	}
	public void setResetClockSet(ArrayList<String> resetClockSet) {
		ResetClockSet = resetClockSet;
	}
	public DBM_element[][] getConstraintDBM() {
		return constraintDBM;
	}
	public void setConstraintDBM(DBM_element[][] constraintDBM) {
		this.constraintDBM = constraintDBM;
	}
	@Override
	public String toString() {
		return "Transition [name=" + name + ", id=" + id + "]";
//		return "Transition [name=" + name + ", id=" + id + ", in=" + in + ", out=" + out + ", condition=" + condition
//				+ ", EventSet=" + EventSet + ", target=" + target + ", source=" + source + ", ResetClockSet="
//				+ ResetClockSet + ", constraintDBM=" + Arrays.toString(constraintDBM) + ", types=" + types
//				+ ", typeIds=" + typeIds + "]";
	}
	
	
}

