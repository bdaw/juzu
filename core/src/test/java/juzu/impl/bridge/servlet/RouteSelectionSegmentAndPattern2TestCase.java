/*
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package juzu.impl.bridge.servlet;

import juzu.test.protocol.standalone.AbstractStandaloneTestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class RouteSelectionSegmentAndPattern2TestCase extends AbstractStandaloneTestCase {

  @Deployment(testable = false)
  public static WebArchive createDeployment() {
    return createDeployment("bridge.servlet.route.selection.segmentandpattern2");
  }

  @Drone
  WebDriver driver;

  @Test
  public void testRender() throws Exception {
    driver.get(deploymentURL.toURI().resolve("./foo/juu").toURL().toString());
    WebElement trigger = driver.findElement(By.tagName("body"));
    assertEquals("juu", trigger.getText());
    driver.get(deploymentURL.toURI().resolve("./foo/daa").toURL().toString());
    trigger = driver.findElement(By.tagName("body"));
    assertEquals("bar:daa", trigger.getText());
  }
}
