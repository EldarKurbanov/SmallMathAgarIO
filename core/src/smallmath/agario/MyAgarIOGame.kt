package smallmath.agario

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class MyAgarIOGame : ApplicationAdapter() {

    private var shapeRenderer: ShapeRenderer? = null
    private val circle = CircleHero()

    override fun create() {
        shapeRenderer = ShapeRenderer()
    }

    override fun render() {
        if (Gdx.input.isTouched) {
            circle.setTarget(Gdx.input.x.toFloat(), (Gdx.graphics.height - Gdx.input.y).toFloat())
        }

        circle.moveTowards(Gdx.graphics.deltaTime)

        Gdx.gl.glClearColor(.25f, .25f, .25f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        shapeRenderer!!.begin(ShapeRenderer.ShapeType.Filled)
        circle.draw(shapeRenderer!!)
        shapeRenderer!!.end()
    }

    override fun dispose() {
        shapeRenderer!!.dispose()
    }

}