package definition;

public interface Algorithm {
	public Game bestMove(Game g, int maxDepth);

	public long eval(Game g, int maxDepth);
}
