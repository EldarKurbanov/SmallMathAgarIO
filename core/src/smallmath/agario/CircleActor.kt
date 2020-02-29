package smallmath.agario

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener

class CircleActor: Actor() {

    val shapeRenderer: ShapeRenderer

    init {
        shapeRenderer = ShapeRenderer()

        addListener(object : InputListener() {
            override fun keyUp(event: InputEvent?, keycode: Int): Boolean {
                return super.keyUp(event, keycode)
            }

            override fun keyDown(event: InputEvent?, keycode: Int): Boolean {
                return super.keyDown(event, keycode)
            }
        })
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        batch!!.end()
        shapeRenderer.projectionMatrix = batch.projectionMatrix
        shapeRenderer.transformMatrix = batch.transformMatrix

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.circle(0f, 0f, 50f)
        shapeRenderer.end()

        batch.begin()
    }
}