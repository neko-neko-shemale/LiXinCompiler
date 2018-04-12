package com.lixin.inter;

import com.lixin.lexer.Tag;
import com.lixin.lexer.Word;
import com.lixin.symbols.Type;

/**
 * @author lixin
 */
public class Access extends Operator {
    public Id array;
    public ExpressionNode index;

    public Access(Id array, ExpressionNode index, Type type) {
        super(new Word("[]", Tag.INDEX), type);
        this.array = array;
        this.index = index;
    }

    @Override
    public ExpressionNode generate() {
        return new Access(array, index.reduce(), type);
    }

    @Override
    public void jumping(int positive, int negative) {
        emitJumps(reduce().toString(), positive, negative);
    }

    @Override
    public String toString() {
        return array.toString() + " [ " + index.toString() + " ]";
    }
}
