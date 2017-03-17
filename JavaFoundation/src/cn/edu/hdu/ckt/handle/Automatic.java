package cn.edu.hdu.ckt.handle;

import java.io.Serializable;
import java.util.ArrayList;

public class Automatic implements Serializable{
	private String name;//����
	private State InitState;//��ʼ״̬
	private ArrayList<Transition> TransitionSet;//ת������
	private ArrayList<State> StateSet;//״̬����
	private ArrayList<String> ClockSet;//ʱ�Ӽ���
	public String getName() {
		return name;
	}
	public void setName(String name ) {
		this.name = name;
	}
	public State getInitState() {
		return InitState;
	}
	public void setInitState(State initState) {
		InitState = initState;
	}
	public ArrayList<Transition> getTransitionSet() {
		return TransitionSet;
	}
	public void setTransitionSet(ArrayList<Transition> transitionSet) {
		TransitionSet = transitionSet;
	}
	public ArrayList<State> getStateSet() {
		return StateSet;
	}
	public void setStateSet(ArrayList<State> stateSet) {
		StateSet = stateSet;
	}
	public ArrayList<String> getClockSet() {
		return ClockSet;
	}
	public void setClockSet(ArrayList<String> clockSet) {
		ClockSet = clockSet;
	}
	@Override
	public String toString() {
		return "Automatic [name=" + name + ", InitState=" + InitState + ", TransitionSet=" + TransitionSet
				+ ", StateSet=" + StateSet + ", ClockSet=" + ClockSet + "]";
	}
	
	
}
