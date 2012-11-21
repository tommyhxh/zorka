/**
 * Copyright 2012 Rafal Lewczuk <rafal.lewczuk@jitlogic.com>
 * <p/>
 * This is free software. You can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this software. If not, see <http://www.gnu.org/licenses/>.
 */

package com.jitlogic.zorka.spy.processors;

import com.jitlogic.zorka.spy.SpyProcessor;
import com.jitlogic.zorka.spy.SpyRecord;

public class TimeDiffProcessor implements SpyProcessor {

    private int tStartSlot, tStopSlot, rsltSlot;


    public TimeDiffProcessor(int tStartSlot, int tStopSlot, int rsltSlot) {
        this.tStartSlot = tStartSlot;
        this.tStopSlot = tStopSlot;
        this.rsltSlot = rsltSlot;
    }


    public SpyRecord process(int stage, SpyRecord record) {
        Object v1 = record.get(stage, tStartSlot), v2 = record.get(stage, tStopSlot);

        if (v1 instanceof Long && v2 instanceof Long) {
            long l1 = (Long)v1, l2 = (Long)v2;
            record.put(stage, rsltSlot, l2-l1);
        } // TODO else (log something here ?)

        return record;
    }


    public int getStartSlot() {
        return tStartSlot;
    }


    public int getStopSlot() {
        return tStopSlot;
    }


    public int getResultSlot() {
        return rsltSlot;
    }
}