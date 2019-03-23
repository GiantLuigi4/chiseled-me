/*
 * Copyright (c) 2016-2019 Anton Bulakh <necauqua@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package necauqua.mods.cm.asm.dsl;

import necauqua.mods.cm.asm.dsl.anchors.Anchor;

public final class Modifier {

    private final ModifierType type;
    private final Anchor anchor;
    private final int nth;
    private final AsmMethodHook hook;

    private boolean matched = false;

    public Modifier(ModifierType type, Anchor anchor, int nth, AsmMethodHook hook) {
        this.type = type;
        this.anchor = anchor;
        this.nth = nth;
        this.hook = hook;
    }

    public AsmMethodHook getHook() {
        return hook;
    }

    public ModifierType getType() {
        return type;
    }

    public boolean didMatch() {
        return matched;
    }

    public ContextMethodVisitor apply(ContextMethodVisitor parent) {
        parent.setPass(1);
        return anchor.apply(parent, this);
    }

    public boolean match(ContextMethodVisitor context, int pass) {
        if (nth != 0 && nth != pass) {
            return false;
        }
        matched = true;
        context.setPass(pass);
        hook.accept(context);
        context.setPass(1);
        return true;
    }

    @Override
    public String toString() {
        return "<" + type + (nth == 0 ?
            " all" :
            "") + " " + anchor + (nth > 1 ?
            " at " + nth :
            "") + ">";
    }
}