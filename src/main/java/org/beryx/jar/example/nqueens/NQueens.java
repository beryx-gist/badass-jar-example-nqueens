/*
 * Copyright 2018 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beryx.jar.example.nqueens;

import org.beryx.streamplify.permutation.Permutations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueens {
    public static List<Solution> solve(int n) {
        if(n < 1 || n > 12) throw new IllegalArgumentException("Invalid size: " + n + ". Accepted values: 1 .. 12");
        return new Permutations(n)
                .parallelStream()
                .filter(perm -> {
                    for (int i = 0; i < perm.length - 1; i++) {
                        for (int j = i + 1; j < perm.length; j++) {
                            if (Math.abs(perm[j] - perm[i]) == j - i) return false;
                        }
                    }
                    return true;
                })
                .map(perm -> {
                    Solution sol = new Solution();
                    IntStream.range(0, perm.length)
                            .forEach(i -> sol.getPositions().add(new Position(i, perm[i])));
                    return sol;
                })
                .collect(Collectors.toList());
    }
}
