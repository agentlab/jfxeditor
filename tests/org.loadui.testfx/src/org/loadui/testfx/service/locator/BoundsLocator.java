/*
 * Copyright 2013 SmartBear Software
 *
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved by the European
 * Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work
 * except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the Licence for the specific language governing permissions
 * and limitations under the Licence.
 */
package org.loadui.testfx.service.locator;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Window;

public interface BoundsLocator {
    Bounds boundsInSceneFor(Node node);

    Bounds boundsInWindowFor(Scene scene);

    Bounds boundsInWindowFor(Bounds boundsInScene, Scene scene);

    Bounds boundsOnScreenFor(Node node);

    Bounds boundsOnScreenFor(Scene scene);

    Bounds boundsOnScreenFor(Window window);

    Bounds boundsOnScreenFor(Bounds boundsInScene, Scene scene);
}
