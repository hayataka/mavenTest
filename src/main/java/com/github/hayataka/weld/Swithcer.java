package com.github.hayataka.weld;

import java.util.Map;

//import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.weld.context.bound.BoundRequestContext;

//@ApplicationScoped
public class Swithcer {

	   /* Inject the BoundRequestContext. */
	   /* Alternatively, you could look this up from the BeanManager */
	   @Inject BoundRequestContext requestContext;

	   /* Start the request, providing a data store which will last the lifetime of the request */
	   public void startRequest(Map<String, Object> requestDataStore) {

	      // Associate the store with the context and activate the context
	      requestContext.associate(requestDataStore);
	      requestContext.activate();
	   }

	   /* End the request, providing the same data store as was used to start the request */
	   public void endRequest(Map<String, Object> requestDataStore) {
	      try {
	         /* Invalidate the request (all bean instances will be scheduled for destruction) */
	         requestContext.invalidate();
	         /* Deactivate the request, causing all bean instances to be destroyed (as the context is invalid) */
	         requestContext.deactivate();
	      } finally {
	         /* Ensure that whatever happens we dissociate to prevent any memory leaks */
	         requestContext.dissociate(requestDataStore);
	      }
	   }
}
