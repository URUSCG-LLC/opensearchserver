/**   
 * License Agreement for OpenSearchServer
 *
 * Copyright (C) 2012 Emmanuel Keller / Jaeksoft
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

package com.jaeksoft.searchlib.result.collector;

import java.io.IOException;

import com.jaeksoft.searchlib.result.ResultScoreDoc;
import com.jaeksoft.searchlib.sort.SorterAbstract;
import com.jaeksoft.searchlib.util.Timer;

public class ResultScoreDocCollector extends AbstractCollector {

	private float maxScore = 0;
	private final ResultScoreDoc[] docs;
	private int pos = 0;

	public ResultScoreDocCollector(int numFound) {
		docs = new ResultScoreDoc[numFound];
	}

	@Override
	final public void collect(int docId) throws IOException {
		float sc = scorer.score();
		if (sc > maxScore)
			maxScore = sc;
		docs[pos++] = new ResultScoreDoc(docId, sc);
	}

	final public ResultScoreDoc[] getDocs() {
		return docs;
	}

	final public float getMaxScore() {
		return maxScore;
	}

	final public void sort(SorterAbstract sort, Timer timer) {
		if (sort == null)
			return;
		sort.quickSort(docs, timer);
	}
}
