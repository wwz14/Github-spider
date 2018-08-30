#!/bin/sh

#  get_debug_log.sh
#  
#
#  Created by 汪文藻 on 17/3/10.
#
cd /Users/alice/eclipse.jdt.debug
#git branch --all > /Users/alice/debugbranch.txt
touch /Users/alice/Desktop/debughistory/debuglog.txt

cat /Users/alice/debugbranch.txt | while read line
do
git checkout $line
git log --after="2016-01-01 00:00:00" --before="2017-01-01 00:00:00" --pretty=format:"%H - %an - %cn - %cd - %s" >> /Users/alice/Desktop/debughistory/debuglog.txt
done
