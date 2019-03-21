package ink.bonismo.web.grpc;

import ink.bonismo.domain.User;
import io.bonismo.UserProviderGrpc;
import io.bonismo.UserProviderOuterClass;
import io.grpc.stub.StreamObserver;
import net.badata.protobuf.converter.Converter;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bonismo@hotmail.com on 2019/3/21 4:48 PM
 *
 * @Description:
 * @Version: 1.0
 */
@GrpcService(UserProviderGrpc.class)
public class UserProvider extends UserProviderGrpc.UserProviderImplBase {

    private final Logger logger = LoggerFactory.getLogger(UserProvider.class);

    @Override
    public void getByUserId(UserProviderOuterClass.UserIdRequest request, StreamObserver<UserProviderOuterClass.UserVoReplay> responseObserver) {

        long userId = request.getId();

        logger.debug("GO GRPC User Id : {}", userId);

//        UserProviderOuterClass.UserVoReplay.Builder userVoReplay = UserProviderOuterClass.UserVoReplay.newBuilder();

        if (0 == userId) {
            userId = 1L;
        }


        User user = new User();
        user.setId(1L);
        user.setEmail("bonismo@hotmail.com");
        user.setName("Li Chao Nan");


        // construct return data
//        userVoReplay.setId(userId);
//        userVoReplay.setName("Zhang San");

        UserProviderOuterClass.UserVoReplay userProto = Converter.create().toProtobuf(UserProviderOuterClass.UserVoReplay.class, user);


        UserProviderOuterClass.UserVoReplay voReplay = userProto.toBuilder().build();

        logger.debug("VoReplay : {}", voReplay.toString());

        // response
        responseObserver.onNext(voReplay);
        responseObserver.onCompleted();

    }
}
