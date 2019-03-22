package ink.bonismo.web.grpc;

import ink.bonismo.domain.User;
import io.bonismo.UserProviderGrpc;
import io.bonismo.UserProviderOuterClass;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import net.badata.protobuf.converter.Converter;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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


    @Override
    public void getList(UserProviderOuterClass.UserIdRequest request, StreamObserver<UserProviderOuterClass.UserPageResponse> responseObserver) {
        logger.debug("GRPC Request id is : {}", request.getId());
        List<User> userList = new ArrayList<>();
        logger.debug("User List Time Before : {}", System.currentTimeMillis());
        for (int i = 0; i < 40000; i++) {
            User user = new User();
            user.setId((long) i);
            user.setEmail(i + "admin@localhost.com");
            user.setName("admin" + i);
            user.setBirth("1990-" + i + "-" + i);
            user.setAge(i);

            user.setMarry(true);

            user.setHeight(1.1);
            user.setWeight(2.2);
            user.setPrice(3.3);
            user.setFinance(4.4f);
            userList.add(user);
        }


        // -----------------------------------------------------------------------------------------------------------------------------------
        // Use Protobuf-Converter Plugins

//        logger.debug("Protobuf-Converter Time Before .");
//        Long listBefore = System.currentTimeMillis();
//
//        // Use Protobuf-Converter Plugins
//        List<UserProviderOuterClass.UserVoReplay> replayList = Converter.create().toProtobuf(UserProviderOuterClass.UserVoReplay.class, userList);
//
//        Long listAfter = System.currentTimeMillis();
//        logger.debug("Proto Data After 1 : {}", System.currentTimeMillis());
//
//        UserProviderOuterClass.UserPageResponse.Builder builder = UserProviderOuterClass.UserPageResponse.newBuilder();
//
//        builder.addAllReplay(replayList);
//        logger.debug("Protobuf-Converter Time After .");
        // -----------------------------------------------------------------------------------------------------------------------------------

        List<UserProviderOuterClass.UserVoReplay> voReplayList = new ArrayList<>();

        logger.debug("Normal Cde Time Before .");
        Long listBefore = System.currentTimeMillis();

        for (User user : userList) {
            UserProviderOuterClass.UserVoReplay.Builder replay = UserProviderOuterClass.UserVoReplay.newBuilder();
            replay.setId(user.getId());
            replay.setName(user.getName());
            replay.setEmail(user.getEmail());
            replay.setBirth(user.getBirth());
            replay.setAge(user.getAge());
            replay.setMarry(user.getMarry());
            replay.setFinance(user.getFinance());
            replay.setHeight(user.getHeight());
            replay.setWeight(user.getWeight());
            replay.setPrice(user.getPrice());
            voReplayList.add(replay.build());

        }
        UserProviderOuterClass.UserPageResponse.Builder builder = UserProviderOuterClass.UserPageResponse.newBuilder();

        builder.addAllReplay(voReplayList);

        Long listAfter = System.currentTimeMillis();
        logger.debug("Normal Cde Time After .");

        // -----------------------------------------------------------------------------------------------------------------------------------


        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(listAfter - listBefore);

        System.out.println("耗时: " + c.get(Calendar.MINUTE) + "分 " + c.get(Calendar.SECOND) + "秒 " + c.get(Calendar.MILLISECOND) + " 微秒");

        UserProviderOuterClass.UserPageResponse response = builder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void createUsers(UserProviderOuterClass.UserPageResponse request, StreamObserver<UserProviderOuterClass.UserIdRequest> responseObserver) {
        super.createUsers(request, responseObserver);
    }

}

