package org.jugni.session.lecturer.resource;

import java.net.URI;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jugni.session.lecturer.model.Lecturer;

/**
 *
 * @author aalaniz
 */
@ApplicationScoped
@Path("lecturers")
public class LecturerResource {

    private Map<String, Lecturer> lecturers;

    @PostConstruct
    public void init() {
        this.lecturers = new ConcurrentHashMap<>();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Lecturer> allLecturer() {
        return lecturers.values();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public LecturerHolder allLecturerForXml() {
        LecturerHolder holder = new LecturerHolder(lecturers.values());
        return holder;
    }

    @GET
    @Path("{id}")
    public Lecturer lecturer(@PathParam("id") String id) {
        return lecturers.get(id);
    }

    @POST
    public Response add(Lecturer lecturer) {
        if (lecturer != null) {
            lecturers.put(lecturer.getJugNiId(), lecturer);
        }
        final URI id = URI.create(lecturer.getJugNiId());
        return Response.created(id).build();
    }
}
