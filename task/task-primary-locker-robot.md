**存包**

given: 1号储物箱未满 when: 存包 then: 成功把包存入1号储物箱，返回一个票据

given: 1~(n-1)号储物箱已满，第n号储物柜未满 when: 存包 then: 成功把包存入第n号储物箱，返回一个票据

given: 所有n个储物箱已满 when: 存包 then: 存包失败，提示【所有储物箱都已满】

**取包**

given: 提供合法票据 when: 取包 then: 成功取出我的包

given: 提供过期的票据 when: 取包 then: 取包失败，提示【过期票】

given: 提供无效的票据 when: 取包 then: 取包失败，提示【无效票】