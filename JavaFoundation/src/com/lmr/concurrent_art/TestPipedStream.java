package com.lmr.concurrent_art;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

public class TestPipedStream {

	public static void main(String[] args) {

		TestPipedStream test = new TestPipedStream();

		try {
			test.TestPiped();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void TestPiped() throws IOException, InterruptedException {

		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

//		in.connect(out);
//		out.connect(in);
		
		Thread inputThread=new Thread(new InputThread(in));
		Thread outputThread=new Thread(new OutputThread(out));
//		Thread outputThread1=new Thread(new OutputThread(out));
		
		outputThread.start();
//		outputThread1.start();
		Thread.sleep(100);
		inputThread.start();
		
	}

	static class InputThread implements Runnable {

		private PipedInputStream in;
		private int revice;

		public InputThread(PipedInputStream in) {
			this.in = in;
		}

		@Override
		public void run() {
			try {
				while ((revice = in.read()) != -1) {
					System.out.print((char)revice);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static class OutputThread implements Runnable {

		private PipedOutputStream out = new PipedOutputStream();

		public OutputThread(PipedOutputStream out) {
			this.out = out;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 100; i++) {
					out.write((i+"\n").getBytes());
					Thread.sleep(100);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
