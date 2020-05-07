**存包**

given: 储物箱未满 when: 存包 then: 成功把包存入储物箱

given: 所有储物箱已满 when: 存包 then: 存包失败，提示【储物箱已满】

**取包**

given: 提供合法票据 when: 扫描票据 then: 成功取出我的包

given: 提供不合法票据 when: 扫描票据 then: 取包失败，提示【无效票】