package de.featjar.formula.analysis.value;

import de.featjar.base.data.Computation;
import de.featjar.base.data.Result;
import de.featjar.formula.analysis.Clause;
import de.featjar.formula.analysis.Solver;
import de.featjar.formula.analysis.bool.BooleanAssignment;
import de.featjar.formula.analysis.bool.BooleanClause;
import de.featjar.formula.analysis.mapping.VariableMap;

import java.util.LinkedHashMap;

/**
 * A value clause; that is, a disjunction of equalities.
 * Often used as input to an SMT {@link Solver}.
 *
 * @author Elias Kuiter
 */
public class ValueClause extends ValueAssignment implements Clause<String> {
    public ValueClause() {
    }

    public ValueClause(LinkedHashMap<String, Object> variableValuePairs) {
        super(variableValuePairs);
    }

    public ValueClause(ValueClause predicateClause) {
        this(new LinkedHashMap<>(predicateClause.variableValuePairs));
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    protected ValueClause clone() {
        return toClause();
    }

    @Override
    public Result<BooleanClause> toBoolean(VariableMap variableMap) {
        return variableMap.toBoolean(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Computation<BooleanClause> toBoolean(Computation<VariableMap> variableMapComputation) {
        return (Computation<BooleanClause>) super.toBoolean(variableMapComputation);
    }

    @Override
    public String toString() {
        return String.format("ValueClause[%s]", print());
    }
}
