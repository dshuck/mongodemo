package mongoexample

import com.mongodb.Mongo
import org.springframework.context.event.ContextStartedEvent
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.SimpleMongoDbFactory

/**
 * Created by b032596 on 9/3/2014.
 */

class MongoApp {

    /* for some reason this autowiring isn't happening.  Not sure why yet.  As of this commit,
    AppConfig.groovy useless

    @Autowired static Mongo mongo
    @Autowired static MongoTemplate mongoTemplate  // not yet being used
    */
    static void main(String[] args) {

        println 'Starting up MongoBoot application'

        MongoOperations mongoOps = new MongoTemplate( new Mongo(), 'database' )

        Person person = new Person( 'Joe', 34 )
        person.things = [ new Thing( 'foo' ), new Thing( 'bar' ) ]

        mongoOps.insert( person )

        Person newPerson = mongoOps.findOne(new Query(org.springframework.data.mongodb.core.query.Criteria.where('name').is('Joe')), Person.class)

        println 'Age: ' + newPerson.age
        println '2nd Thing: ' + newPerson.things[1].name

        mongoOps.dropCollection('person')
    }

    void onApplicationEvent(ContextStartedEvent event) {
    }

}

