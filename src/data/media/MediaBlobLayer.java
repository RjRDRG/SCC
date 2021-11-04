package data.media;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.models.BlobItem;

public class MediaBlobLayer {

	static String STORAGE_CONNECTION = "DefaultEndpointsProtocol=https;AccountName=scc22;AccountKey=3Krm6JzIwF4vAmXcWMnsDBwXVcvJoDNjBh5tXy0w7xF+djzBRNEKjqo6Tk/let/O48tJp4RkmqkKpHiLpBR+0w==;EndpointSuffix=core.windows.net";

	final BlobContainerClient containerClient;
	
	public MediaBlobLayer() {
		containerClient = new BlobContainerClientBuilder()
				.connectionString(STORAGE_CONNECTION)
				.containerName("images")
				.buildClient();
	}
	
	public void upload(String id, byte[] contents) {
		BlobClient blob = containerClient.getBlobClient(id);
		blob.upload(BinaryData.fromBytes(contents));
	}
	
	public byte[] download(String id) {
		BlobClient result = containerClient.getBlobClient(id);
		if(!result.exists())
			throw new NotFoundException();

		return result.downloadContent().toBytes();	
	}
	

	public List<String> list() {
		return containerClient.listBlobs().stream().map(BlobItem::getName).collect(Collectors.toList());
	}
}
