/*
 *
 *  Copyright 2015 Robert Winkler
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */
package org.rakam.client.utils;

import io.swagger.models.ArrayModel;
import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.RefModel;
import io.github.robwin.markup.builder.MarkupLanguage;
import org.apache.commons.lang3.Validate;

public final class ModelUtils {

    public static String getType(Model model) {
        Validate.notNull(model, "model must not be null!");
        if (model instanceof ModelImpl) {
            return ((ModelImpl) model).getType();
        } else if (model instanceof RefModel) {
            return ((RefModel) model).getSimpleRef();
        } else if (model instanceof ArrayModel) {
            ArrayModel arrayModel = ((ArrayModel) model);
            return PropertyUtils.getType(arrayModel.getItems()) + " " + arrayModel.getType();
        }
        return "NOT FOUND";
    }
}
