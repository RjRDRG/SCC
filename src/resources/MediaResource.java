package resources;


import data.media.MediaBlobLayer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resource for managing media files, such as images.
 */
@Path("/media")
public class MediaResource
{
	static String STORAGE_CONNECTION = "DefaultEndpointsProtocol=https;AccountName=scc22;AccountKey=3Krm6JzIwF4vAmXcWMnsDBwXVcvJoDNjBh5tXy0w7xF+djzBRNEKjqo6Tk/let/O48tJp4RkmqkKpHiLpBR+0w==;EndpointSuffix=core.windows.net";

	final MediaBlobLayer mediaLayer;

	public MediaResource() {
		mediaLayer = new MediaBlobLayer();
	}

	/**
	 * Post a new image.The id of the image is its hash.
	 */
	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces(MediaType.APPLICATION_JSON)
	public void upload(@PathParam("name") String id, byte[] contents) {
		mediaLayer.upload(id, contents);
	}

	/**
	 * Return the contents of an image. Throw an appropriate error message if
	 * id does not exist.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public byte[] download(@PathParam("id") String id) {
		return mediaLayer.download(id);
	}

	/**
	 * Lists the ids of images stored.
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> list() {
		return mediaLayer.list();
	}
}
