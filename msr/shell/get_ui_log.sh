#!/bin/sh

#  get_ui_log.sh
#  
#
#  Created by 汪文藻 on 17/3/10.
#
cd /Users/alice/eclipse.jdt.ui
git branch --all > /Users/alice/uibranch.txt
#读取所有分支的名字，重定向到corebranch.txt中
touch /Users/alice/Desktop/uihistory/uilog.txt
cat /Users/alice/uibranch.txt | while read line
do
git checkout $line
#切换分支
git log --after="2016-01-01 00:00:00" --before="2017-01-01 00:00:00" --pretty=format:"%H w_w_z %an w_w_z %cn w_w_z %cd w_w_z %s" >> /Users/alice/Desktop/uihistory/uilog.txt

done
