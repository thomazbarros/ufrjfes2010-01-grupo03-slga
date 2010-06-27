package control.base.media;

import java.media.*;
import java.net.*;

public class VoiceTool implements ReceiveStreamListener{
	
	private DataSource inputDataSource, outputDataSource;
	private AudioFormat audioFormat;
	private Vector devices;
	private CaptureDeviceInfo captureDeviceInfo;
	private Player player;
	private URL url;
	private MediaLocator mediaLocator;
	private DataSink dataSink;
	private Processor processor;
	private RTPSessionMgr voiceSessionManager;
	private SendStream sendStream;
	
	public VoiceTool(){
		inputDataSource = null;
		outputDataSource = null;
		audioFormat = null;
		devices = null;
		captureDeviceInfo = null;
		player = null;
		url = null;
		mediaLocator = null;
		dataSink = null;
		processor = null;
		voiceSessionManager = null;
		sendStream = null;
	}
	/*public void captureAudioLive(){
		audioFormat = new AudioFormat(AudioFormat.LINEAR,8000,8,1);
		devices = CaptureDeviceManager.getDeviceList(audioFormat);
		captureDeviceInfo = (CaptureDeviceInfo) devices.elementAt(0);
		dataSource = Manager.createDataSource(captureDeviceInfo.getLocator());
	}
	
	public void playAudio(){
		player = Manager.createPlayer(dataSource);
		player.start();
	}
	
	public void sendAudio(){
		mediaLocator = new MediaLocator(url);
		dataSink = Manager.createDataSink(dataSource, mediaLocator);
		dataSink.open();
		dataSink.start();
	}*/
	
	int startMedia(String peerIp, int peerPort, int receivePort){
		audioFormat = new AudioFormat(AudioFormat.LINEAR,8000,8,1);
		devices = CaptureDeviceManager.getDeviceList(audioFormat);
		captureDeviceInfo = (CaptureDeviceInfo) devices.elementAt(0);
		inputDataSource = Manager.createDataSource(captureDeviceInfo.getLocator());
		
		processor = Manager.createProcessor(inputDataSource);
		processor.configure();
		while (processor.getState()!=Processor.Configured) {
			Thread.sleep(20);
		}
		processor.setContentDescriptor(new ContentDescriptor(ContentDescriptor.RAW_RTP));
		TrackControl track[]=processor.getTrackControls();
		switch (fmt) {
		case 3: audioFormat = new AudioFormat(AudioFormat.GSM_RTP,8000,4,1);
		case 4: audioFormat = new AudioFormat(AudioFormat.G723_RTP,8000,4,1);
		}
		track[0].setFormat(audioFormat);
		processor.realize();
		while (processor.getState() != Processor.Realized) {
			Thread.sleep(20)
		}
		
		outputDataSource = processor.getDataOutput();
		
		voiceSessionManager = new RTPSessionMgr();
		voiceSessionManager.addReceiveStreamListener(this);
		SessionAddress senderAddress = new SessionAddress();
		voiceSessionManager.initSession(senderAddress,null,0.05,0.25);
		InetAddress destinationAddress = InetAddress.getByName(peerIP);
		SessionAddress localAddress = new SessionAddress (InetAddress.getLocalHost(),receivePort,InetAddress.getLocalHost(),receivePort+1);
		SessionAddress remoteAddress = new SessionAddress(destinationAddress,peerPort,destinationAddress,peerPort+1);
		voiceSessionManager.startSession(localAddress,localAddress,remoteAddress,null);
		
		sendStream.start();
		processor.start();
	}
}