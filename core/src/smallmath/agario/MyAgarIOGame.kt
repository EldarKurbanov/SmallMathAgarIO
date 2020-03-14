package smallmath.agario

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.utils.viewport.ExtendViewport

class MyAgarIOGame : ApplicationAdapter() {

    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: ExtendViewport
    private lateinit var stage: Stage
    private lateinit var circleActor: CircleActor
    private lateinit var spriteBatch: SpriteBatch
    lateinit var background: Texture

    override fun create() {
        camera = OrthographicCamera(640f, 480f)
        viewport = ExtendViewport(640f, 480f, camera)
        stage = Stage(viewport)

        circleActor = CircleActor()
        spriteBatch = SpriteBatch()
        background = Texture("background.jpg")

        stage.addActor(circleActor)
        Gdx.input.inputProcessor = stage
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        spriteBatch.begin()
        val textureRegion = TextureRegion(background, Gdx.graphics.width, Gdx.graphics.height)
        spriteBatch.draw(textureRegion, 0f, 0f)
        spriteBatch.end()

        camera.position.set(Vector3(circleActor.x, circleActor.y, 0f))
        camera.update()
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun dispose() {
        stage.dispose()
    }


}