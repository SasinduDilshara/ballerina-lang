/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.langlib.array;

import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.types.TypeTags;
import io.ballerina.runtime.api.utils.TypeUtils;
import io.ballerina.runtime.api.values.BArray;

import static org.ballerinalang.langlib.array.utils.ArrayUtils.createOpNotSupportedError;

/**
 * Native implementation of lang.array:push((any|error)[], (any|error)...).
 *
 * @since 1.0
 */
public class Push {

    private static final String FUNCTION_SIGNATURE = "push()";

    private Push() {
    }

    public static void push(BArray arr, Object... vals) {
        Type arrType = TypeUtils.getImpliedType(arr.getType());
        int nVals = vals.length;
        switch (arrType.getTag()) {
            case TypeTags.ARRAY_TAG:
            case TypeTags.TUPLE_TAG:
                for (int i = arr.size(), j = 0; j < nVals; i++, j++) {
                    arr.add(i, vals[j]);
                }
                break;
            default:
                throw createOpNotSupportedError(arrType, FUNCTION_SIGNATURE);
        }
    }
}
