<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <GetAnnouncement @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></GetAnnouncement>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>모집공고명</th>
                        <th>모집공고내용</th>
                        <th>대상단지명</th>
                        <th>대상단지위치</th>
                        <th>신청시작일자</th>
                        <th>신청종료일자</th>
                        <th>입주시작일자</th>
                        <th>입주종료일자</th>
                        <th>자격요건</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="모집공고명">{{ val.title }}</td>
                            <td class="whitespace-nowrap" label="모집공고내용">{{ val.content }}</td>
                            <td class="whitespace-nowrap" label="대상단지명">{{ val.houseName }}</td>
                            <td class="whitespace-nowrap" label="대상단지위치">{{ val.houseLocation }}</td>
                            <td class="whitespace-nowrap" label="신청시작일자">{{ val.applyStartDate }}</td>
                            <td class="whitespace-nowrap" label="신청종료일자">{{ val.applyEndDate }}</td>
                            <td class="whitespace-nowrap" label="입주시작일자">{{ val.moveInStartDate }}</td>
                            <td class="whitespace-nowrap" label="입주종료일자">{{ val.moveInEndDate }}</td>
                            <td class="whitespace-nowrap" label="자격요건">{{ val.eligibilityCriteria }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Announcement 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Announcement :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Announcement 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="모집공고명" v-model="selectedRow.title" :editMode="true"/>
                            <String label="모집공고내용" v-model="selectedRow.content" :editMode="true"/>
                            <String label="대상단지명" v-model="selectedRow.houseName" :editMode="true"/>
                            <String label="대상단지위치" v-model="selectedRow.houseLocation" :editMode="true"/>
                            <Date label="신청시작일자" v-model="selectedRow.applyStartDate" :editMode="true"/>
                            <Date label="신청종료일자" v-model="selectedRow.applyEndDate" :editMode="true"/>
                            <Date label="입주시작일자" v-model="selectedRow.moveInStartDate" :editMode="true"/>
                            <Date label="입주종료일자" v-model="selectedRow.moveInEndDate" :editMode="true"/>
                            <String label="자격요건" v-model="selectedRow.eligibilityCriteria" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'announcementGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'announcements',
    }),
    watch: {
    },
    methods:{
    }
}

</script>