package resources;

import data.message.Message;
import data.message.MessageDAO;
import data.message.MessagesDBLayer;
import java.util.UUID;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resource for managing messages.
 */

public class MessageResource {

	final MessagesDBLayer dbLayer;

	public MessageResource() {
				dbLayer = MessagesDBLayer.getInstance();
			}

	/**
	 * Create a new message.
	 */
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String create(Message message) {
		String messageId = UUID.randomUUID().toString();
		message.setId(messageId);

		if (dbLayer.putMsg(new MessageDAO (message)).getStatusCode() >= 400)
			throw new BadRequestException();

		return messageId;
	}

	/**
	 * Update a new message.
	 */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Message message) {
		if (dbLayer.updatemsg(new MessageDAO (message)).getStatusCode() >= 400)
			throw new BadRequestException();
	}

	/**
	 * Delete a message.
	 */
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") String id) {
		if (dbLayer.delMsgById(id).getStatusCode() >= 400)
			throw new BadRequestException();
	}

}
