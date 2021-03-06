import resources.ControlResource;
import resources.MediaResource;
import resources.UsersResource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MainApplication extends Application
{
	private final Set<Object> singletons = new HashSet<>();
	private final Set<Class<?>> resources = new HashSet<>();

	public MainApplication() {
		resources.add(ControlResource.class);
		resources.add(UsersResource.class);
//		resources.add(MediaResource.class);
//		singletons.add(new MediaResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return resources;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}