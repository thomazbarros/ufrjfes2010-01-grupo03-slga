package control.base.signaling;

class SignalingLayer {
    public void startSession(Peer requester, SignalingListener listener);
    public void confirmSession(Session session);
    public void endSession(Session session);
}
