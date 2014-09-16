/**   
 * License Agreement for OpenSearchServer
 *
 * Copyright (C) 2014 Emmanuel Keller / Jaeksoft
 * 
 * http://www.open-search-server.com
 * 
 * This file is part of OpenSearchServer.
 *
 * OpenSearchServer is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * OpenSearchServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with OpenSearchServer. 
 *  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.jaeksoft.searchlib.util.array;

import it.unimi.dsi.fastutil.ints.IntArrayList;

public class IntBufferedArray extends IntArrayList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8094082944608411296L;

	private int[] finalArray = null;

	public IntBufferedArray(final int maxSize, final int arraySize) {
		super(arraySize);
	}

	public IntBufferedArray(final int maxSize) {
		super(1024);
	}

	public final int[] getFinalArray() {
		if (finalArray == null)
			finalArray = toIntArray();
		return finalArray;
	}

	@Override
	public final void clear() {
		super.clear();
		finalArray = null;
	}
}
