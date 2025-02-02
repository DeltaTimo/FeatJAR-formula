/*
 * Copyright (C) 2023 Sebastian Krieter, Elias Kuiter
 *
 * This file is part of FeatJAR-formula.
 *
 * formula is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3.0 of the License,
 * or (at your option) any later version.
 *
 * formula is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with formula. If not, see <https://www.gnu.org/licenses/>.
 *
 * See <https://github.com/FeatureIDE/FeatJAR-formula> for further information.
 */
package de.featjar.formula.io;

import static de.featjar.formula.structure.Expressions.*;
import static org.junit.jupiter.api.Assertions.fail;

import de.featjar.base.io.format.IFormat;
import de.featjar.formula.io.textual.ExpressionFormat;
import de.featjar.formula.structure.formula.IFormula;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link ExpressionFormat Formula} format.
 *
 * @author Sebastian Krieter
 */
public class ExpressionFormatTest {

    // @Test //TODO
    public void Formula_ABC_nAnBnC() {
        test("ABC-nAnBnC");
    }

    // @Test //TODO
    public void Formula_empty() {
        test("faulty");
    }

    @Test
    public void Formula_nA() {
        test("nA");
    }

    @Test
    public void Formula_nAB() {
        test("nAB");
    }

    private static void test(String name) {
        FormatTest.testLoadAndSave(getFormula(name), name, (IFormat) new ExpressionFormat());
    }

    private static IFormula getFormula(String name) {
        switch (name) {
            case "faulty": {
                return null;
            }
            case "ABC-nAnBnC": {
                return and(
                        or(literal("A"), literal("B"), literal("C")),
                        or(not(literal("A")), or(not(literal("B")), not(literal("C")))));
            }
            case "nA": {
                return not(literal("A"));
            }
            case "nAB": {
                return or(not(literal("A")), literal("B"));
            }
            default:
                fail(name);
                return null;
        }
    }
}
