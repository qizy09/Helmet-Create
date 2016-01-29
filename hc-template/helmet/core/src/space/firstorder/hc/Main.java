package space.firstorder.hc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.math.MathUtils;

public class Main extends ApplicationAdapter {
	public SpriteBatch sprites;
	public Environment environment;

	public PerspectiveCamera cam;

	public ModelBatch modelBatch;
	public ModelInstance instance;
	public Model model;

	public Texture logo;

	/*
		add variables here if you need any, in the case you're doing
		texturing or something more complicated
	*/

	@Override
	public void create() {
		// TODO: create completely new batches for sprites and models

		// TODO: create a new environment
		// set a new color attribute for ambient light in the environment
		// add a new directional light to the environment

		// create a new logo texture from the "data/firstorder.png" file
		logo = new Texture("data/firstorder.png");

		// TODO: create a new perspective camera with a field-of-view of around 70, 
		//  and the width and height found in the Gdx.graphics class
		// set the position of the camera to (100, 100, 100)
		// set the camera to look at the origin point (0, 0, 0)
		// set the near and far planes of the camera to 1 and 300
		// update the camera

		// create a new model loader
		final ModelLoader modelLoader = new ObjLoader();

		// TODO: load the internal file "data/stormtrooper.obj" into the model variable
		model = modelLoader.loadModel(Gdx.files.internal("data/stormtrooper.obj"));

		// TODO: create a new model instance and scale it to 20% it's original size (it's huge...)

		// TODO: set the helmet details material to a new diffuse black color attribute

        // set the input processor to work with our custom input:
        //  clicking the image in the lower right should change the colors of the helmets
        //  bonus points: implement your own GestureDetector and an input processor based on it
		Gdx.input.setInputProcessor(new FirstOrderInputProcessor(cam, new Runnable() {
			public void run() {
				// TODO: change the helmet details material to a new diffuse random color

                // bonus points:
                //  randomly change the material of the helmet base to a texture
                //  from the files aloha.png and camouflage.png (or add your own!)
			}
		}));
	}

	@Override
	public void render() {
		// create a new viewport of size (0, 0, width, height)
		//	the width and height you can get from the Gdx.graphics
		// clear the color and depth buffer
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		// TODO: begin the model batch with the current camera
		// render the instance of the model in the set-up environment using the model batch
		// end the model batch rendering process

		// TODO: begin the sprite batch rendering
		// draw the new order logo at (50, 50, 200, 200)
		// end the sprite batch rendering process
	}

	@Override
	public void dispose () {
		// TODO: dispose of the model and sprite batch
		// TODO: dispose of the model
	}

	/*
		play with this if you want to make more colorful helmets
	 */
	protected NodePart getHelmetBase() {
		return instance.nodes.get(0).parts.get(0);
	}

	protected NodePart getHelmetDetails() {
		return instance.nodes.get(1).parts.get(0);
	}

	protected Color getRandomColor() {
		return new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), MathUtils.random());
	}
}