package control.base.signaling;

public interface SignalingListener {
    public void sessionStarted(Session session);
    public void sessionConfirmed(Session session);
    public void sessionEnded(Session session);
}
