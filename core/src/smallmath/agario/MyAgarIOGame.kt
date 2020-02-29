package smallmath.agario

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.utils.viewport.ExtendViewport

class MyAgarIOGame : ApplicationAdapter() {

    var camera: OrthographicCamera? = null
    var viewport: ExtendViewport? = null
    var stage: Stage? = null
    var circleActor: CircleActor? = null

    override fun create() {
        camera = OrthographicCamera(640f, 480f)
        viewport = ExtendViewport(640f, 480f, camera)
        stage = Stage(viewport)
        Gdx.input.inputProcessor = stage
        circleActor = CircleActor()
        stage!!.addActor(circleActor)
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera!!.position.set(Vector3(circleActor!!.x, circleActor!!.y, 0f))
        camera!!.update()
        stage!!.act(Gdx.graphics.deltaTime)
        stage!!.draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport!!.update(width, height, true)
    }

    override fun dispose() {
        stage!!.dispose()
    }


}