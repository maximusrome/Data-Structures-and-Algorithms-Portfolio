class StackException extends Exception {
    private static final long serialVersionUID = 1L;

    public StackException(final String msg) {
        super(msg);
    }

    public StackException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
