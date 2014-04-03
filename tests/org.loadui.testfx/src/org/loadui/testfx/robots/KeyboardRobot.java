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
package org.loadui.testfx.robots;

import javafx.scene.input.KeyCode;

public interface KeyboardRobot {

    /**
     * Presses and holds a given key, until explicitly released.
     *
     * @param keyCodes the key codes
     */
    public void press(KeyCode... keyCodes);

    /**
     * Releases a given key.
     *
     * @param keyCodes the key codes
     */
    public void release(KeyCode... keyCodes);

}
