#!/bin/sh

#  getlog.sh
#  
#
#  Created by 汪文藻 on 17/3/10.
#
#touch /Users/alice/githistory/ui.txt
#touch /Users/alice/githistory/corehistory-p.txt
#touch /Users/alice/githistory/binhistory-p.txt
#touch /Users/alice/githistory/lshistory-p.txt
#touch /Users/alice/githistory/jdthistory-p.txt
#touch /Users/alice/githistory/debughistory-p.txt
cd /Users/alice/eclipse.jdt.ui
git log --after="2016-01-01 00:00:00" --before="2016-12-31 23:59:59" --pretty=oneline -p > /Users/alice/githistory/uilog.txt

cd /Users/alice/eclipse.jdt.core
git log --after="2016-01-01 00:00:00" --before="2016-12-31 23:59:59" > /Users/alice/githistory/corelog.txt

cd /Users/alice/eclipse.jdt.core.binaries
git log --after="2016-01-01 00:00:00" --before="2016-12-31 23:59:59" > /Users/alice/githistory/binlog.txt

cd /Users/alice/eclipse.jdt.ls
git log --after="2016-01-01 00:00:00" --before="2016-12-31 23:59:59" > /Users/alice/githistory/lslog.txt

cd /Users/alice/eclipse.jdt
git log --after="2016-01-01 00:00:00" --before="2016-12-31 23:59:59" > /Users/alice/githistory/jdtlog.txt

cd /Users/alice/eclipse.jdt.debug
git log --after="2016-01-01 00:00:00" --before="2016-12-31 23:59:59" > /Users/alice/githistory/debuglog.txt

