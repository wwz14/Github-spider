#!/bin/sh

#  get_core_log.sh
#  
#
#  Created by 汪文藻 on 17/3/10.
#

cd /Users/alice/eclipse.jdt.core
#git branch --all > /Users/alice/corebranch.txt
#读取所有分支的名字，重定向到corebranch.txt中
touch /Users/alice/Desktop/corehistory/corelog.txt
cat /Users/alice/corebranch.txt | while read line
do
git checkout $line
#切换分支
git log --after="2016-01-01 00:00:00" --before="2017-01-01 00:00:00" --pretty=format:"%H - %an - %cn - %cd - %s" -p >> /Users/alice/Desktop/corehistory/corelog.txt

done
