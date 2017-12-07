package model;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	public int getZ();
	public void draw(GraphicsContext gc);
	public default boolean isDestroyed() {
		return this.isVisible();
	};
	public default boolean isVisible() {
		return this.isVisible();
	};
}
