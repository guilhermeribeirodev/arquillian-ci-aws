package org.base.guidev;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class AppTest{
        @Deployment(testable = false)
        public static WebArchive createDeployment() {
            return ShrinkWrap.create(WebArchive.class, "test.war")
                    .addClasses(MyService.class)
                    .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        }

        @EJB
        MyService myService;

        @Test
        public void test(){
            System.out.println(myService.method());
        }

}
