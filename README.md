# BOJ
- Baekjoon Online Judge 
- 서울 16반 알고리즘 스터디 B팀
- [[싸피 8기] 서울 16반 알고리즘 스터디 B팀 그룹 바로가기](https://www.acmicpc.net/group/15323)


## pre-requirements
- [Baekjoon Online Judge Account](https://www.acmicpc.net/)
- [Git](https://git-scm.com/)
## members


## requirements
   ```
   1. SSAFY8-Seoul16-AlgorithmStudy-B/BOJ 스터디 저장소 Fork
   2. 본인의 스터디 저장소를 Clone (로컬의 저장소 폴더가 생성됩니다.)
   $ git clone https://github.com/[자신의 계정이름]/BOJ.git
   3. SSAFY8-Seoul16-AlgorithmStudy-B/BOJ의 스터디 저장소와 동기화 (변경된 내역을 나의 저장소에도 일치시켜주는 작업)
   
   # 먼저 로컬부터 동기화해줘야 합니다. (Fork 하기 전의 레포. 즉, SSAFY8-Seoul16-AlgorithmStudy-B/BOJ 레포의 remote 이름을 "upstream"이라고 해줍니다.)
   # upstream 추가 -> 통상적으로 upstream이라고 해주는게 원칙입니다.
   $ git remote add upstream https://github.com/SSAFY8-Seoul16-AlgorithmStudy-B/BOJ.git
   # upstream 레포의 변경 내역을 로컬의 저장소와 병합합니다.
   $ git pull upstream main
   
   4. 자신의 github id로 된 폴더(ex: xfrnk2) 생성합니다.
  
   5. xfrnk2 폴더로 이동합니다.

   6. 코드작업을 시작하기 전에 원본 레포지토리로부터 pull을 받고 진행합니다.
   # pull을 이용하여 원본 레포지토리의 main 브랜치에 있는 최신 파일들을 받아옵니다.
   $ git pull upstream main

   7. 코드작업 진행 (파일명 : BOJ0000.py)
   
   7.5 코드 작업이 끝나고 다시 pull을 받아옵니다.
   # 코드 작업중 누군가가 새로운 파일을 push할 가능성이 있으므로 최신화 합니다.
   $ git pull upstream main
   
   8. 깃 Staging Area에 저장합니다. (ex: git add 파일명)
   # 파일명에 "."을 하면 현재 폴더의 전체 파일이 tracked 됩니다.
   $ git add . 
   
   9. ".git" 폴더에 저장 (ex: git commit -m "이름: 메세지") -> "-m"은 message의 약자입니다.
   $ git commit -m "xfrnk2: BOJ0000 풀이"
   
   10. 본인이 Fork한 깃헙 저장소에 업로드 (ex: git push <Remote> <Branch>)
   $ git push origin main
   
   11. 본인이 Fork한 깃헙 저장소로 이동하여 Pull Request(PR)를 보냅니다.
    ❗ 이때, SSAFY8-Seoul16-AlgorithmStudy-B/BOJ 저장소의 main 브랜치가 아닌 "복사한 레포지토리"로 보내야 합니다.
    이후 스터디 그룹장이 확인한 후 SSAFY8-Seoul16-AlgorithmStudy-B/BOJ 저장소의 main 브랜치로 병합시켜주는 작업을 하게 됩니다.
   
   12. 다른 스터디원의 문제 풀이가 올라온 경우 다음 주차가 넘어가지 전까지 코드리뷰를 해줍니다.
   ```
## precaution
- **git pull**을 이용하여 코드작업 전, 후로 꼭 **최신화** 시켜주도록 합니다.
- **git pull**을 이용하면 **다른 사람의 폴더가 자신의 작업 환경에 생기는데** 이때 다른 사람의 폴더를 **절대로 삭제**하지 않습니다.
- **pull**을 사용할 때에는 **원본 레포지토리**를 이용합니다.
- **push**을 할 때에는 **fork한 개인 레포지토리**를 이용합니다.


## workflow
1. 백준 > 그룹 > [[싸피 8기] 서울 16반 알고리즘 스터디 B팀](https://www.acmicpc.net/group/15323) > 연습 > 해당 주차를 선택합니다. 
2. 작성한 코드를 자신의 github id 폴더에 저장합니다.
4. 저장한 파일을 개인별 Fork한 Repo의 main으로 PUSH합니다.
5. 개인별 깃허브 Repo에 PUSH된 main Branch를 스터디 팀 BOJ 저장소의 main Branch로 PR를 요청합니다.


