<template>
    <div>
        <String
            label="청약단지명"
            v-model="value.houseName"
            :editMode="editMode"
        />
        <String
            label="청약단지위치"
            v-model="value.houseLocation"
            :editMode="editMode"
        />
        <String
            label="접수자명"
            v-model="value.recipientName"
            :editMode="editMode"
        />
        <String
            label="신청서류"
            v-model="value.documentFile"
            :editMode="editMode"
        />
        <String
            label="접수자휴대폰번호"
            v-model="value.phoneNumber"
            :editMode="editMode"
        />
        <String
            label="접수자Email"
            v-model="value.email"
            :editMode="editMode"
        />
        <AnnouncementId
            offline
            label="모집공고정보"
            v-model="value.announcementId"
            :editMode="editMode"
            @change="change"
        />
        <ApplyStatus
            offline
            label="접수상태"
            v-model="value.applyStatus"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Subscription',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscriptions",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
