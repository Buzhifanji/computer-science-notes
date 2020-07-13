// 工厂方法模式
// 参考资料：https://refactoringguru.cn/design-patterns/factory-method

// 抽象产品
interface Machine {
    process(material: string): string,
    getName(): string,
}


// 抽象工厂
abstract class FactoryMachine {
    public abstract factoryMethod(): Machine
    public someOperation(material: string): string {
        const machine = this.factoryMethod();
        console.log(machine.process(material))
        return `加工${machine.getName()}完成`
    }
}

// 具体工厂
class ConcreteSteamedBn extends FactoryMachine {
    public factoryMethod(): Machine {
        return new ConcreteSteamedBn();
    }

    public process(material: string): string {
        return `将${material}加工成馒头`
    }
    public getName(): string {
        return '馒头'
    }
}

// 具体产品
class SteamedBunMachine implements Machine {
    public process(material: string) {
        return `我把${material}加工成了馒头`
    }
    public getName(): string {
        return '馒头'
    }
}

// 具体工厂
class ConcteteBoodle extends FactoryMachine {
    public factoryMethod(): Machine {
        return new ConcteteBoodle();
    }

    public process(material: string) {
        return `将${material}加工成面条`
    }

    public getName(): string {
        return '面条'
    }
}

// 具体产品
class BoodleMachine implements Machine {
    public process(material: string) {
        return `我把${material}加工成了面条`
    }
    public getName(): string {
        return '面条'
    }
}

function doProcess(factory: FactoryMachine) {
    console.log('要是开始加工了')
    console.log(factory.someOperation('面粉'))
}

console.log('开始')
doProcess(new ConcreteSteamedBn())
console.log('======')
doProcess(new ConcteteBoodle())
console.log('结束')