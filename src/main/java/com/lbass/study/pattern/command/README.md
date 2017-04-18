# Command Pattern
##### Command 패턴에 대한 예제 코드입니다.
##### 호텔에서 사용하는 통합리모컨을 생각하면 됩니다.
##### 다음은 클래스에 대한 설명입니다.

### Invoker
##### &nbsp;&nbsp; Command를 실행하는 Invoker 입니다. 리모컨 자체가 됩니다.
###### &nbsp;&nbsp;&nbsp;&nbsp; RemoteController

### Command
##### &nbsp;&nbsp; 실행(execute)과 취소(undo)가 가능하며 Receiver를 컨트롤하여 원하는 동작을 수행합니다.
###### &nbsp;&nbsp;&nbsp;&nbsp; LightOnCommand
###### &nbsp;&nbsp;&nbsp;&nbsp; LightOffCommand

### Receiver
##### 명령에 맞는 실제 동작을 합니다.
###### &nbsp;&nbsp;&nbsp;&nbsp; Light

##### 사용자의 명령은 Command가 되어 Invoker에 저장됩니다.
##### 입력받은 명령은 Invoker에 누적이 되며 주기적으로 실행됩니다.
