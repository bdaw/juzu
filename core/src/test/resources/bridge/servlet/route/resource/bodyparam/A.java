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

package bridge.servlet.route.resource.bodyparam;

import juzu.Controller;
import juzu.Resource;
import juzu.Response;
import juzu.Route;
import juzu.View;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class A extends Controller {

  @View
  public Response.Content index() {
    return Response.render(
        "<form id='form' action='" + A_.fooURL(null) + "' method='post'>" +
        "<input type='hidden' name='juu' value='bar'/>" +
        "<input id='trigger' type='submit' name='click'/>" +
        "</form>");
  }

  @Resource
  @Route("/foo")
  public Response.Content foo(String juu) {
    return Response.ok("" + juu);
  }
}
